package wci.frontend.subc;

import java.util.Hashtable;
import java.util.HashSet;

import wci.frontend.TokenType;

/**
 * <h1>SubCTokenType</h1>
 *
 * <p>SubC token types.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public enum SubCTokenType implements TokenType
{
    // Reserved words.
	IF, INT, CHAR, CONST, VAR, PROCEDURE, FUNCTION, DOUBLE, WHILE, MAIN, ELSE, RETURN,

    // Special symbols.
    PLUS("+"), MINUS("-"), STAR("*"), SLASH("/"), MOD("%"),
    PERIOD("."), SEMICOLON(";"), DBQUOTE("\""), ASSIGNMENT("="),
    EQUALS("=="), NOT_EQUALS("!="), LESS_THAN("<"), LESS_EQUALS("<="),
    GREATER_EQUALS(">="), GREATER_THAN(">"), LEFT_PAREN("("), RIGHT_PAREN(")"),
    LEFT_BRACKET("["), RIGHT_BRACKET("]"), LEFT_BRACE("{"), RIGHT_BRACE("}"),
    COMMA(","), AND("&&"), OR("||"), NOT("!"), SYS("#"),

    IDENTIFIER, INTEGER, REAL, CHARACTER, STRING,
    ERROR, END_OF_FILE;

    private static final int FIRST_RESERVED_INDEX = IF.ordinal();
    private static final int LAST_RESERVED_INDEX  = RETURN.ordinal();

    private static final int FIRST_SPECIAL_INDEX = PLUS.ordinal();
    private static final int LAST_SPECIAL_INDEX = SYS.ordinal();
    
    private String text;  // token text

    /**
     * Constructor.
     */
    SubCTokenType()
    {
        this.text = this.toString().toLowerCase();
    }

    /**
     * Constructor.
     * @param text the token text.
     */
    SubCTokenType(String text)
    {
        this.text = text;
    }

    /**
     * Getter.
     * @return the token text.
     */
    public String getText()
    {
        return text;
    }

    // Set of lower-cased SubC reserved word text strings.
    public static HashSet<String> RESERVED_WORDS = new HashSet<String>();
    static {
        SubCTokenType values[] = SubCTokenType.values();
        for (int i = FIRST_RESERVED_INDEX; i <= LAST_RESERVED_INDEX; ++i) {
            RESERVED_WORDS.add(values[i].getText().toLowerCase());
        }
    }

    // Hash table of SubC special symbols.  Each special symbol's text
    // is the key to its SubC token type.
    public static Hashtable<String, SubCTokenType> SPECIAL_SYMBOLS =
        new Hashtable<String, SubCTokenType>();
    static {
        SubCTokenType values[] = SubCTokenType.values();
        for (int i = FIRST_SPECIAL_INDEX; i <= LAST_SPECIAL_INDEX; ++i) {
            SPECIAL_SYMBOLS.put(values[i].getText(), values[i]);
        }
    }
}
