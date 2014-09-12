package com.reddit.dailyprogrammer.hughwphamill.greyscale;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AveragingConverter implements Converter {

    @Override
    public BufferedImage convert(BufferedImage input) {
        BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
        for (int x = 0; x < input.getWidth(); x++) {
            for (int y = 0; y < input.getHeight(); y++) {
                Color color = new Color(input.getRGB(x, y));
                int level = (color.getRed() + color.getBlue() + color.getGreen()) / 3;
                Color grey = new Color(level, level, level);
                output.setRGB(x, y, grey.getRGB());
            }
        }

        return output;
    }

    @Override
    public String suffix() {
        return "_avgbw";
    }

    @Override
    public String description() {
        return "Convert using average colour values";
    }
}
