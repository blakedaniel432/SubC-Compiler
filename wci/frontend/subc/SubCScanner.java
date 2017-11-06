package wci.frontend.subc;

import wci.frontend.*;
import wci.frontend.subc.tokens.*;

import static wci.frontend.Source.EOF;
import static wci.frontend.subc.SubCTokenType.*;
import static wci.frontend.subc.SubCErrorCode.*;

/**
 * <h1>SubCScanner</h1>
 *
 * <p>The SubC scanner.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class SubCScanner extends Scanner
{
    /**
     * Constructor
     * @param source the source to be used with this scanner.
     */
    public SubCScanner(Source source)
    {
        super(source);
    }

    /**
     * Extract and return the next SubC token from the source.
     * @return the next token.
     * @throws Exception if an error occurred.
     */
    protected Token extractToken()
        throws Exception
    {
        skipWhiteSpace();

        Token token;
        char currentChar = currentChar();

        // Construct the next token.  The current character determines the
        // token type.
        if (currentChar == EOF) {
            token = new EofToken(source);
        }
        else if (Character.isLetter(currentChar) || currentChar == '_') {
            token = new SubCWordToken(source);
        }
        else if (Character.isDigit(currentChar)) {
            token = new SubCNumberToken(source);
        }
        else if (currentChar == '\"') {
            token = new SubCStringToken(source);
        }
        else if (currentChar == '\'') {
        	token = new SubCCharToken(source);
        }
        else if (SubCTokenType.SPECIAL_SYMBOLS
                 .containsKey(Character.toString(currentChar)) || (currentChar == '&' && peekChar() == '&') || (currentChar == '|' && peekChar() == '|')) {
            token = new SubCSpecialSymbolToken(source);
        }
        else {
            token = new SubCErrorToken(source, INVALID_CHARACTER,
                                         Character.toString(currentChar));
            nextChar();  // consume character
        }

        return token;
    }

    /**
     * Skip whitespace characters by consuming them.  A comment is whitespace.
     * @throws Exception if an error occurred.
     */
    private void skipWhiteSpace()
        throws Exception
    {
        char currentChar = currentChar();
        

        while (Character.isWhitespace(currentChar) || (currentChar == '/' && (peekChar() == '/' || peekChar() == '*'))) {
            // Checks to see if comment starts with "//" or "/*"
            if (currentChar == '/' && peekChar() == '/') {
            	int oldLine = getLineNum(); //stores current line
            	
            	do {
                    currentChar = nextChar();  // consume comment characters
                } while (oldLine == getLineNum() && currentChar != EOF); //continues until line advances
            }
            else if (currentChar == '/' && peekChar() == '*') {
            	nextChar();
            	
            	do {
            		currentChar = nextChar();  // consume comment characters
                } while ((currentChar != '*' && peekChar() != '/') && currentChar != EOF);
            	
            	nextChar();
            	currentChar = nextChar(); //consumes "*/"
            	
            }	
            else {
                currentChar = nextChar();  // consume whitespace character
            }
        }
    }
}
