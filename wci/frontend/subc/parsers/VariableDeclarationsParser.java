package wci.frontend.subc.parsers;

import java.util.ArrayList;
import java.util.EnumSet;

import wci.frontend.*;
import wci.frontend.subc.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;

import static wci.frontend.subc.SubCTokenType.*;
import static wci.frontend.subc.SubCErrorCode.*;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.symtabimpl.DefinitionImpl.*;
import static wci.intermediate.typeimpl.TypeFormImpl.*;
import static wci.intermediate.typeimpl.TypeKeyImpl.*;

/**
 * <h1>VariableDeclarationsParser</h1>
 *
 * <p>
 * Parse SubC variable declarations.
 * </p>
 *
 * <p>
 * Copyright (c) 2009 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class VariableDeclarationsParser extends DeclarationsParser {
	private Definition definition; // how to define the identifier
	protected TypeSpec type;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent parser.
	 */
	public VariableDeclarationsParser(SubCParserTD parent) {
		super(parent);
	}

	/**
	 * Setter.
	 * 
	 * @param definition
	 *            the definition to set.
	 */
	protected void setDefinition(Definition definition) {
		this.definition = definition;
	}

	// Synchronization set for a variable identifier.
	static final EnumSet<SubCTokenType> IDENTIFIER_SET = DeclarationsParser.VAR_START_SET.clone();
	static {
		IDENTIFIER_SET.add(IDENTIFIER);
		IDENTIFIER_SET.add(SEMICOLON);
	}

	// Synchronization set for the start of the next definition or declaration.
	static final EnumSet<SubCTokenType> NEXT_START_SET = DeclarationsParser.ROUTINE_START_SET.clone();
	static {
		NEXT_START_SET.add(IDENTIFIER);
		NEXT_START_SET.add(SEMICOLON);
	}

	/**
	 * Parse variable declarations.
	 * 
	 * @param token
	 *            the initial token.
	 * @throws Exception
	 *             if an error occurred.
	 */
	public void parse(Token token) throws Exception {
		// Parse the type specification.
		type = parseTypeSpec(token);
		token = synchronize(IDENTIFIER_SET);

		// Loop to parse a sequence of variable declarations
		// separated by semicolons.
		if (token.getType() == IDENTIFIER) {

			// Parse the identifier sublist and its type specification.
			parseIdentifierSublist(token);

			token = currentToken();
			TokenType tokenType = token.getType();

			// Look for one or more semicolons after a definition.
			if (tokenType == SEMICOLON) {
				token = nextToken(); // consume the ;
			}

			// If at the start of the next definition or declaration,
			// then missing a semicolon.
			else if (NEXT_START_SET.contains(tokenType)) {
				errorHandler.flag(token, MISSING_SEMICOLON, this);
			}

			// token = synchronize(IDENTIFIER_SET);
		}
	}

	// Synchronization set to start a sublist identifier.
	static final EnumSet<SubCTokenType> IDENTIFIER_START_SET = EnumSet.of(IDENTIFIER, COMMA);

	// Synchronization set to follow a sublist identifier.
	private static final EnumSet<SubCTokenType> IDENTIFIER_FOLLOW_SET = EnumSet.of(SEMICOLON);
	static {
		IDENTIFIER_FOLLOW_SET.addAll(DeclarationsParser.VAR_START_SET);
	}

	// Synchronization set for the , token.
	private static final EnumSet<SubCTokenType> COMMA_SET = EnumSet.of(COMMA, IDENTIFIER, SEMICOLON);

	/**
	 * Parse a sublist of identifiers and their type specification.
	 * 
	 * @param token
	 *            the current token.
	 * @return the sublist of identifiers in a declaration.
	 * @throws Exception
	 *             if an error occurred.
	 */
	protected ArrayList<SymTabEntry> parseIdentifierSublist(Token token) throws Exception {
		ArrayList<SymTabEntry> sublist = new ArrayList<SymTabEntry>();

		do {
			token = synchronize(IDENTIFIER_START_SET);
			SymTabEntry id = parseIdentifier(token);

			if (id != null) {
				sublist.add(id);
			}

			token = synchronize(COMMA_SET);
			TokenType tokenType = token.getType();

			// Look for the comma.
			if (tokenType == COMMA) {
				token = nextToken(); // consume the comma

				if (IDENTIFIER_FOLLOW_SET.contains(token.getType())) {
					errorHandler.flag(token, MISSING_IDENTIFIER, this);
				}
			} else if (IDENTIFIER_START_SET.contains(tokenType)) {
				errorHandler.flag(token, MISSING_COMMA, this);
			}
		} while (!IDENTIFIER_FOLLOW_SET.contains(token.getType()));

		// Assign the type specification to each identifier in the list.
		for (SymTabEntry variableId : sublist) {
			variableId.setTypeSpec(type);
		}

		return sublist;
	}

	/**
	 * Parse an identifier.
	 * 
	 * @param token
	 *            the current token.
	 * @return the symbol table entry of the identifier.
	 * @throws Exception
	 *             if an error occurred.
	 */
	private SymTabEntry parseIdentifier(Token token) throws Exception {
		SymTabEntry id = null;

		if (token.getType() == IDENTIFIER) {
			String name = token.getText(); //REMOVED .toLowerCase()
			id = symTabStack.lookupLocal(name);

			// Enter a new identifier into the symbol table.
			if (id == null) {
				id = symTabStack.enterLocal(name);
				id.setDefinition(definition);
				id.appendLineNumber(token.getLineNumber());
			} else {
				errorHandler.flag(token, IDENTIFIER_REDEFINED, this);
			}

			token = nextToken(); // consume the identifier token

		} else {
			errorHandler.flag(token, MISSING_IDENTIFIER, this);
		}

		return id;
	}

	/**
	 * Parse the type specification.
	 * 
	 * @param token
	 *            the current token.
	 * @return the type specification.
	 * @throws Exception
	 *             if an error occurs.
	 */
	protected TypeSpec parseTypeSpec(Token token) throws Exception {
		// Parse the type specification.
		TypeSpecificationParser typeSpecificationParser = new TypeSpecificationParser(this);
		TypeSpec type = typeSpecificationParser.parse(token);

		return type;
	}
}
