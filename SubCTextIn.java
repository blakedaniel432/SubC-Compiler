import java.io.*;

import wci.frontend.Scanner;
import wci.frontend.Source;
import wci.frontend.Token;
import wci.frontend.TokenType;
import wci.frontend.subc.SubCScanner;

import static wci.frontend.subc.SubCTokenType.*;

/**
 * <h1>SubCTextIn</h1>
 *
 * <p>SubC Runtime Library:
 * Runtime text input for SubC programs, based on the front end scanner.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class SubCTextIn
{
    private static Scanner scanner;  // based on the SubC scanner

    static {
        try {
            scanner = new SubCScanner(
                          new Source(
                              new BufferedReader(
                                  new InputStreamReader(System.in))));
        }
        catch (Exception ignored) {}
    }

    /**
     * Read the next integer value.
     * @return the integer value.
     * @throws SubCRuntimeException if an error occurred.
     */
    public int readInteger()
        throws SubCRuntimeException
    {
        Token token = null;

        try {
            token = scanner.nextToken();
            return (Integer) parseNumber(token, true);
        }
        catch (Exception ex) {
            throw new SubCRuntimeException(
                          "Read error: invalid integer value: '" +
                          token.getText() + "'");
        }
    }

    /**
     * Read the next real value.
     * @return the real value.
     * @throws SubCRuntimeException if an error occurred.
     */
    public float readReal()
        throws SubCRuntimeException
    {
        Token token = null;

        try {
            token = scanner.nextToken();
            return (Float) parseNumber(token, false);
        }
        catch (Exception ex) {
            throw new SubCRuntimeException(
                          "Read error: invalid real value: '" +
                          token.getText() + "'");
        }
    }

    /**
     * Read the next boolean value.
     * @return the boolean value.
     * @throws SubCRuntimeException if an error occurred.
     */
    public boolean readBoolean()
        throws SubCRuntimeException
    {
        Token token = null;

        try {
            token = scanner.nextToken();
            return parseBoolean(token);
        }
        catch (Exception ex) {
            throw new SubCRuntimeException(
                          "Read error: invalid boolean value: '" +
                          token.getText() + "'");
        }
    }

    /**
     * Read the next character value.
     * @return the character value.
     * @throws SubCRuntimeException if an error occurred.
     */
    public char readChar()
        throws SubCRuntimeException
    {
        char ch = ' ';

        try {
            ch = scanner.nextChar();

            if ((ch == Source.EOL) || (ch == Source.EOF)) {
                ch = ' ';
            }

            return ch;
        }
        catch (Exception ex) {
            throw new SubCRuntimeException(
                          "Read error: invalid character value: '" +
                          ch + "'");
        }
    }

    /**
     * Skip the rest of the current input line.
     * @throws SubCRuntimeException if an error occurred.
     */
    public void nextLine()
        throws SubCRuntimeException
    {
        try {
            scanner.skipToNextLine();
        }
        catch (Exception ex) {}
    }

    /**
     * Test for the end of the current input line.
     * @return true if at end of line, else false.
     * @throws SubCRuntimeException if an error occurred.
     */
    public boolean atEoln()
    throws SubCRuntimeException
    {
        try {
            return scanner.atEol();
        }
        catch (Exception ex) {
            return false;
        }
    }

    /**
     * Test for the end of file.
     * @return true if at end of file, else false.
     * @throws SubCRuntimeException if an error occurred.
     */
    public boolean atEof()
        throws SubCRuntimeException
    {
        try {
            return scanner.atEof();
        }
        catch (Exception ex) {
            return false;
        }
    }

    /**
     * Parse an integer or real value from the standard input.
     * @param token the current input token.
     * @param isInteger true to parse an integer, false to parse a real.
     * @return the integer or real value.
     * @throws Exception if an error occurred.
     */
    private Number parseNumber(Token token, boolean isInteger)
        throws Exception
    {
        TokenType tokenType = token.getType();
        TokenType sign = null;

        // Leading sign?
        if ((tokenType == PLUS) || (tokenType == MINUS)) {
            sign = tokenType;
            token = scanner.nextToken();
            tokenType = token.getType();
        }

        // Integer value.
        if (tokenType == INTEGER) {
            Number value = sign == MINUS ? -((Integer) token.getValue())
                           : (Integer) token.getValue();
            return isInteger ? value : new Float(((Integer) value).intValue());
        }

        // Real value.
        else if (tokenType == REAL) {
            Number value = sign == MINUS ? -((Float) token.getValue())
                           : (Float) token.getValue();
            return isInteger ? new Integer(((Float) value).intValue()) : value;
        }

        // Bad input.
        else {
            throw new Exception();
        }
    }

    /**
     * Parse a boolean value from the standard input.
     * @param token the current input token.
     * @param type the input value type.
     * @return the boolean value.
     * @throws Exception if an error occurred.
     */
    private Boolean parseBoolean(Token token)
        throws Exception
    {
        if (token.getType() == IDENTIFIER) {
            String text = token.getText();

            if (text.equalsIgnoreCase("true")) {
                return new Boolean(true);
            }
            else if (text.equalsIgnoreCase("false")) {
                return new Boolean(false);
            }
            else {
                throw new Exception();
            }
        }
        else {
            throw new Exception();
        }
    }
}
