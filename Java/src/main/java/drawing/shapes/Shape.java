package drawing.shapes;

import drawing.writing.JPEGWriter;
import drawing.writing.PNGWriter;

import java.io.IOException;
import java.io.Writer;

import javax.swing.text.AbstractWriter;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public interface Shape {

    /**
     * Converts shape into lines.
     *
     * @return lines of this shape.
     */
    Line[] toLines();
    // private Line[] toLines() {
    // }
    /**
     * Draws lines to file.
     */
    default void draw(Writer writer, Line[] lines) { // Line[] lines 要刪掉在裡面直接做
        try {
            for (Line line : lines) {
                // TODO: what is the purpose of the code there?
                if (writer instanceof JPEGWriter) {
                    writer.write(line.toJPEG());
                } else if (writer instanceof PNGWriter) {
                    writer.write(line.toPNG());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // default void draw(AbstractWriter writer) {
    //     try {
    //         for (Line line : toLines()) {
    //             writer.writeLine(line);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
