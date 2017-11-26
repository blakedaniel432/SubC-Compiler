package wci.frontend.subc;

import wci.frontend.*;

/**
 * <h1>SubCToken</h1>
 *
 * <p>
 * Base class for SubC token classes.
 * </p>
 *
 * <p>
 * Copyright (c) 2009 by Ronald Mak
 * </p>
 * <p>
 * For instructional purposes only. No warranties.
 * </p>
 */
public class SubCToken extends Token {
	/**
	 * Constructor.
	 * 
	 * @param source
	 *            the source from where to fetch the token's characters.
	 * @throws Exception
	 *             if an error occurred.
	 */
	protected SubCToken(Source source) throws Exception {
		super(source);
	}
}
