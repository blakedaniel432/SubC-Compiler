package wci.frontend.subc.tokens;

import wci.frontend.*;
import wci.frontend.subc.*;

import static wci.frontend.Source.EOL;
import static wci.frontend.Source.EOF;
import static wci.frontend.subc.SubCTokenType.*;
import static wci.frontend.subc.SubCErrorCode.*;

/**
 * <h1>SubCStringToken</h1>
 *
 * <p>
 * SubC string tokens.
 * </p>
 *
 * <p>
 * Copyright (c) 2009 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class SubCCharToken extends SubCToken {
	/**
	 * Constructor.
	 * 
	 * @param source
	 *            the source from where to fetch the token's characters.
	 * @throws Exception
	 *             if an error occurred.
	 */
	public SubCCharToken(Source source) throws Exception {
		super(source);
	}

	/**
	 * Extract a SubC string token from the source.
	 * 
	 * @throws Exception
	 *             if an error occurred.
	 */
	protected void extract() throws Exception {
		StringBuilder textBuffer = new StringBuilder();
		StringBuilder valueBuffer = new StringBuilder();

		char currentChar = nextChar(); // consume initial quote
		textBuffer.append('\'');

		if ((currentChar != '\'') && (currentChar != EOF)) {
			textBuffer.append(currentChar);
			valueBuffer.append(currentChar);
			currentChar = nextChar(); // consume character
		}

		if (currentChar == '\'') {
			nextChar(); // consume final quote
			textBuffer.append('\'');

			type = CHAR;
			value = valueBuffer.toString();
		} else {
			type = ERROR;
			value = UNEXPECTED_EOF;
		}

		text = textBuffer.toString();
	}
}
