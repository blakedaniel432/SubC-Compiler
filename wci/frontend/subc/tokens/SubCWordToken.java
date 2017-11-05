package wci.frontend.subc.tokens;

import wci.frontend.*;
import wci.frontend.subc.*;

import static wci.frontend.subc.SubCTokenType.*;

/**
 * <h1>SubCWordToken</h1>
 *
 * <p> SubC word tokens (identifiers and reserved words).</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class SubCWordToken extends SubCToken
{
    /**
     * Constructor.
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public SubCWordToken(Source source)
        throws Exception
    {
        super(source);
    }

    /**
     * Extract a SubC word token from the source.
     * @throws Exception if an error occurred.
     */
    protected void extract()
        throws Exception
    {
        StringBuilder textBuffer = new StringBuilder();
        char currentChar = currentChar();

        // Get the word characters (letter or digit).  The scanner has
        // already determined that the first character is a letter.
        while (Character.isLetterOrDigit(currentChar) || currentChar == '_') {
            textBuffer.append(currentChar);
            currentChar = nextChar();  // consume character
        }

        text = textBuffer.toString();

        // Is it a reserved word or an identifier?
        type = (RESERVED_WORDS.contains(text)) //removed .toLowerCase() because SubC is case-sensitive
               ? SubCTokenType.valueOf(text.toUpperCase())  // reserved word
               : IDENTIFIER;                                  // identifier
    }
}
