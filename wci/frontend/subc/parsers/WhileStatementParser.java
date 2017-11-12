package wci.frontend.subc.parsers;

import java.util.EnumSet;

import wci.frontend.*;
import wci.frontend.subc.*;
import wci.intermediate.*;
import wci.intermediate.icodeimpl.*;

import static wci.frontend.subc.SubCTokenType.*;
import static wci.frontend.subc.SubCErrorCode.*;
import static wci.intermediate.icodeimpl.ICodeNodeTypeImpl.*;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

/**
 * <h1>WhileStatementParser</h1>
 *
 * <p>Parse a SubC WHILE statement.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class WhileStatementParser extends StatementParser
{
    /**
     * Constructor.
     * @param parent the parent parser.
     */
    public WhileStatementParser(SubCParserTD parent)
    {
        super(parent);
    }

    // Synchronization set for DO.
    private static final EnumSet<SubCTokenType> DO_SET =
        StatementParser.STMT_START_SET.clone();
    static {
        DO_SET.add(LEFT_BRACE);
        DO_SET.addAll(StatementParser.STMT_FOLLOW_SET);
    }

    /**
     * Parse a WHILE statement.
     * @param token the initial token.
     * @return the root node of the generated parse tree.
     * @throws Exception if an error occurred.
     */
    public ICodeNode parse(Token token)
        throws Exception
    {
        token = nextToken();  // consume the WHILE

        // Create LOOP, TEST, and NOT nodes.
        ICodeNode loopNode = ICodeFactory.createICodeNode(LOOP);
        ICodeNode breakNode = ICodeFactory.createICodeNode(TEST);
        ICodeNode notNode = ICodeFactory.createICodeNode(ICodeNodeTypeImpl.NOT);

        // The LOOP node adopts the TEST node as its first child.
        // The TEST node adopts the NOT node as its only child.
        loopNode.addChild(breakNode);
        breakNode.addChild(notNode);
        
        // Parse the expression.
        // The NOT node adopts the expression subtree as its only child.
        ExpressionParser expressionParser = new ExpressionParser(this);
        notNode.addChild(expressionParser.parse(token));

        // Synchronize at the DO.
        token = synchronize(DO_SET);
        if (token.getType() == LEFT_BRACE) {
            token = nextToken();  // consume the DO
        }
        else {
            errorHandler.flag(token, MISSING_DO, this);
        }

        // Parse the statement.
        // The LOOP node adopts the statement subtree as its second child.
        StatementParser statementParser = new StatementParser(this);
        statementParser.parseList(token, loopNode, RIGHT_BRACE, MISSING_END); //possible fix
        //loopNode.addChild(statementParser.parse(token)); //default

        return loopNode;
    }
}
