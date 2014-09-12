package com.reddit.dailyprogrammer.hughwphamill.greyscale;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GreenConverter implements Converter {
    @Override
    public BufferedImage convert(BufferedImage input) {
        BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
        for (int x = 0; x < input.getWidth(); x++) {
            for (int y = 0; y < input.getHeight(); y++) {
                Color color = new Color(input.getRGB(x, y));
                int level = new Double(color.getRed()*0.1d + color.getBlue()*0.2d + color.getGreen()*0.7d).intValue();
                Color grey = new Color(level, level, level);
                output.setRGB(x, y, grey.getRGB());
            }
        }

        return output;
    }

    @Override
    public String suffix() {
        return "_grebw";
    }

    @Override
    public String description() {
        return "Convert using Green filter";
    }
}
