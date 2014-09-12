package com.reddit.dailyprogrammer.hughwphamill.greyscale;

import java.awt.image.BufferedImage;

/**
 * Interface which defines an image converter
 */
public interface Converter
{
	 /**
	  * Take the input image and convert it to the output image.
	  */
	 BufferedImage convert(BufferedImage input);

    /**
     * The suffix for the converted filename.
     */
    public String suffix();

    /**
     * A description of this converter.
     */
    public String description();
}
