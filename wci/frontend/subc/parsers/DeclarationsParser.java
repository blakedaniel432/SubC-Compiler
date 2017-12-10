package wci.frontend.subc.parsers;

import java.util.EnumSet;

import wci.frontend.*;
import wci.frontend.subc.*;
import wci.intermediate.*;

import static wci.frontend.subc.SubCTokenType.*;
import static wci.frontend.subc.SubCErrorCode.*;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.symtabimpl.DefinitionImpl.VARIABLE;

/**
 * <h1>DeclarationsParser</h1>
 *
 * <p>
 * Parse SubC declarations.
 * </p>
 *
 * <p>
 * Copyright (c) 2009 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class DeclarationsParser extends SubCParserTD {
	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent parser.
	 */
	public DeclarationsParser(SubCParserTD parent) {
		super(parent);
	}

	static final EnumSet<SubCTokenType> DECLARATION_START_SET = EnumSet.of(CONST, INT, CHAR, PROCEDURE, FUNCTION);

	static final EnumSet<SubCTokenType> TYPE_START_SET = DECLARATION_START_SET.clone();
	static {
		TYPE_START_SET.remove(CONST);
	}

	static final EnumSet<SubCTokenType> VAR_START_SET = TYPE_START_SET.clone();
	/*static {
		VAR_START_SET.remove(TYPE);
	}*/

	static final EnumSet<SubCTokenType> ROUTINE_START_SET = VAR_START_SET.clone();
	static {
		ROUTINE_START_SET.remove(INT);
		ROUTINE_START_SET.remove(CHAR);
	}

	/**
	 * Parse declarations. To be overridden by the specialized declarations parser
	 * subclasses.
	 * 
	 * @param token
	 *            the initial token.
	 * @param parentId
	 *            the symbol table entry of the parent routine's name.
	 * @return null
	 * @throws Exception
	 *             if an error occurred.
	 */
	public SymTabEntry parse(Token token, SymTabEntry parentId) throws Exception {
		// token = synchronize(DECLARATION_START_SET);

		if (token.getType() == CONST) {
			token = nextToken(); // consume CONST

			ConstantDefinitionsParser constantDefinitionsParser = new ConstantDefinitionsParser(this);
			constantDefinitionsParser.parse(token, null);
		}

		// token = synchronize(VAR_START_SET);

		else if (VAR_START_SET.contains(token.getType())) {
			// token = nextToken(); // consume VAR

			VariableDeclarationsParser variableDeclarationsParser = new VariableDeclarationsParser(this);
			variableDeclarationsParser.setDefinition(VARIABLE);
			variableDeclarationsParser.parse(token, null);
		}

		// token = synchronize(ROUTINE_START_SET);
		TokenType tokenType = token.getType();

		while ((tokenType == PROCEDURE) || (tokenType == FUNCTION)) {
			DeclaredRoutineParser routineParser = new DeclaredRoutineParser(this);
			routineParser.parse(token, parentId);

			// Look for one or more semicolons after a definition.
			token = currentToken();
			if (token.getType() == SEMICOLON) {
				while (token.getType() == SEMICOLON) {
					token = nextToken(); // consume the ;
				}
			}

			// token = synchronize(ROUTINE_START_SET);
			tokenType = token.getType();
		}

		return null;
	}
}
