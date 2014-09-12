package com.reddit.dailyprogrammer.hughwphamill.greyscale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

public class GreyscaleApp {

    public static void main(String... args) {
        SortedMap<Integer, Converter> converterMap;
        converterMap = new TreeMap<>();
        converterMap.put(1, new AveragingConverter());
        converterMap.put(2, new BinaryConverter());
        converterMap.put(3, new LuminosityConverter());
        converterMap.put(4, new RedConverter());
        converterMap.put(5, new GreenConverter());
        converterMap.put(6, new BlueConverter());
        CommandMenu menu = new CommandMenu(converterMap);

        do {
            String fileName = menu.getInputFile();
            try {
                File inputFile = new File(fileName);
                BufferedImage input = ImageIO.read(inputFile);
                Converter converter = menu.selectConversion();
                BufferedImage output = converter.convert(input);
                String outFileName = fileName.substring(0, fileName.lastIndexOf('.')) + converter.suffix() + fileName.substring(fileName.lastIndexOf('.'));
                File outputFile = new File(outFileName);
                ImageIO.write(output, "PNG", outputFile);
            } catch (IOException e) {
                menu.outputError(e);
            }
        } while (!menu.askForExit());
    }
}
