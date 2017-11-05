package wci.frontend;

/*import static wci.message.MessageType.SOURCE_LINE;

import java.io.IOException;

import wci.message.Message;
REMOVE COMMENT IF THERE IS AN ISSUE*/

/**
 * <h1>Scanner</h1>
 *
 * <p>A language-independent framework class.  This abstract scanner class
 * will be implemented by language-specific subclasses.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public abstract class Scanner
{
    protected Source source;     // source
    private Token currentToken;  // current token

    /**
     * Constructor
     * @param source the source to be used with this scanner.
     */
    public Scanner(Source source)
    {
        this.source = source;
    }

    /**
     * @return the current token.
     */
    public Token currentToken()
    {
        return currentToken;
    }

    /**
     * Return next token from the source.
     * @return the next token.
     * @throws Exception if an error occurred.
     */
    public Token nextToken()
        throws Exception
    {
        currentToken = extractToken();
        return currentToken;
    }

    /**
     * Do the actual work of extracting and returning the next token from the
     * source. Implemented by scanner subclasses.
     * @return the next token.
     * @throws Exception if an error occurred.
     */
    protected abstract Token extractToken()
        throws Exception;

    /**
     * Call the source's currentChar() method.
     * @return the current character from the source.
     * @throws Exception if an error occurred.
     */
    public char currentChar()
        throws Exception
    {
        return source.currentChar();
    }

    /**
     * Call the source's nextChar() method.
     * @return the next character from the source.
     * @throws Exception if an error occurred.
     */
    public char nextChar()
        throws Exception
    {
        return source.nextChar();
    }
    
    /**
     * Call the source's peekChar() method.
     * @return the next character from the source.
     * @throws Exception if an error occurred.
     */
    public char peekChar()
        throws Exception
    {
        return source.peekChar();
    }
    
    /**
     * Calls the source's getLineNum() method.
     * @return the current line number from the source.
     */
    public int getLineNum()
    {
        return source.getLineNum();
    }
}


