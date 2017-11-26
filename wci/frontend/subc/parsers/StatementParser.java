package wci.frontend.subc.parsers;

import java.util.EnumSet;

import wci.frontend.*;
import wci.frontend.subc.*;
import wci.intermediate.*;

import static wci.frontend.subc.SubCTokenType.*;
import static wci.frontend.subc.SubCErrorCode.*;
import static wci.intermediate.icodeimpl.ICodeNodeTypeImpl.*;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

/**
 * <h1>StatementParser</h1>
 *
 * <p>Parse a SubC statement.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class StatementParser extends SubCParserTD
{
    /**
     * Constructor.
     * @param parent the parent parser.
     */
    public StatementParser(SubCParserTD parent)
    {
        super(parent);
    }

    // Synchronization set for starting a statement.
    protected static final EnumSet<SubCTokenType> STMT_START_SET =
        EnumSet.of(LEFT_BRACE, SWITCH, FOR, SubCTokenType.IF, DO, WHILE,
                   IDENTIFIER, SEMICOLON,INT,CHAR,DOUBLE,FLOAT,CONST);

    // Synchronization set for following a statement.
    protected static final EnumSet<SubCTokenType> STMT_FOLLOW_SET =
        EnumSet.of(SEMICOLON, ELSE, WHILE, CASE);

    /**
     * Parse a statement.
     * To be overridden by the specialized statement parser subclasses.
     * @param token the initial token.
     * @return the root node of the generated parse tree.
     * @throws Exception if an error occurred.
     */
    public ICodeNode parse(Token token)
        throws Exception
    {
        ICodeNode statementNode = null;

        switch ((SubCTokenType) token.getType()) {

            case LEFT_BRACE: {
                CompoundStatementParser compoundParser =
                    new CompoundStatementParser(this);
                statementNode = compoundParser.parse(token);
                break;
            }

            // An assignment statement begins with a variable's identifier.
            case IDENTIFIER: {
                AssignmentStatementParser assignmentParser =
                    new AssignmentStatementParser(this);
                statementNode = assignmentParser.parse(token);
                break;
            }

            case INT:{
                DeclarationsParser declarationsParser =
                    new DeclarationsParser(this);
                declarationsParser.parse(token);
                statementNode = null;
                break;
            }
            case CHAR:{
                DeclarationsParser declarationsParser =
                    new DeclarationsParser(this);
                declarationsParser.parse(token);
                statementNode = null;
                break;
            }
            case FLOAT:{
                DeclarationsParser declarationsParser =
                    new DeclarationsParser(this);
                declarationsParser.parse(token);
                statementNode = null;
                break;
            }
            case DOUBLE:{
                DeclarationsParser declarationsParser =
                    new DeclarationsParser(this);
                declarationsParser.parse(token);
                statementNode = null;
                break;
            }
            case CONST:{
                DeclarationsParser declarationsParser =
                    new DeclarationsParser(this);
                declarationsParser.parse(token);
                statementNode = null;
                break;
            }

            case DO: {
                RepeatStatementParser repeatParser =
                    new RepeatStatementParser(this);
                statementNode = repeatParser.parse(token);
                break;
            }

            case WHILE: {
                WhileStatementParser whileParser =
                    new WhileStatementParser(this);
                statementNode = whileParser.parse(token);
                break;
            }
            /*
            case FOR: {
                ForStatementParser forParser = new ForStatementParser(this);
                statementNode = forParser.parse(token);
                break;
            }
            */
            case IF: {
                IfStatementParser ifParser = new IfStatementParser(this);
                statementNode = ifParser.parse(token);
                break;
            }
            /*
            case SWITCH: {
                CaseStatementParser caseParser = new CaseStatementParser(this);
                statementNode = caseParser.parse(token);
                break;
            }
            */
            default: {
                statementNode = ICodeFactory.createICodeNode(NO_OP);
                break;
            }
        }

        // Set the current line number as an attribute.
        setLineNumber(statementNode, token);

        return statementNode;
    }

    /**
     * Set the current line number as a statement node attribute.
     * @param node ICodeNode
     * @param token Token
     */
    protected void setLineNumber(ICodeNode node, Token token)
    {
        if (node != null) {
            node.setAttribute(LINE, token.getLineNumber());
        }
    }

    /**
     * Parse a statement list.
     * @param token the curent token.
     * @param parentNode the parent node of the statement list.
     * @param terminator the token type of the node that terminates the list.
     * @param errorCode the error code if the terminator token is missing.
     * @throws Exception if an error occurred.
     */
    protected void parseList(Token token, ICodeNode parentNode,
                             SubCTokenType terminator,
                             SubCErrorCode errorCode)
        throws Exception
    {
        // Synchronization set for the terminator.
        EnumSet<SubCTokenType> terminatorSet = STMT_START_SET.clone();
        terminatorSet.add(terminator);

        // Loop to parse each statement until the END token
        // or the end of the source file.
        while (!(token instanceof EofToken) &&
               (token.getType() != terminator)) {

            // Parse a statement.  The parent node adopts the statement node.
            ICodeNode statementNode = parse(token);
            parentNode.addChild(statementNode);

            token = currentToken();
            TokenType tokenType = token.getType();

            // Look for the semicolon between statements.
            if (tokenType == SEMICOLON) {
                token = nextToken();  // consume the ;
            }

            // If at the start of the next statement, then missing a semicolon.
            //else if (STMT_START_SET.contains(tokenType)) {
            //   errorHandler.flag(token, MISSING_SEMICOLON, this);
            //}

            // Synchronize at the start of the next statement
            // or at the terminator.
            token = synchronize(terminatorSet);
        }

        // Look for the terminator token.
        if (token.getType() == terminator) {
            token = nextToken();
        }
        else {
            errorHandler.flag(token, errorCode, this);
        }
    }
}
