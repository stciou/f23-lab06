package drawing;

import drawing.shapes.Line;
import drawing.shapes.Shape;
import drawing.writing.JPEGWriter;
import drawing.writing.PNGWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Drawing {

    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Draw shapes to a file with given file format.
     *
     * @param format   file format
     * @param filename file name
     */
    // task 3: Duplication and Lack of Extensibility & Exposure of Shape Internals
    public void draw(String format, String filename) {
        // TODO: Do you notice any issues here?
        // draw 包含用於處理JPEG和PNG格式的重複程式塊。 這種缺乏可擴充套件性是一個問題，因為每次引入新檔案格式時都需要修改繪製方法。
        if (format.equals("jpeg")) {
            try (Writer writer = new JPEGWriter(filename + ".jpeg")) {
                for (Shape shape : this.shapes) {
                    // TODO: What is the issue of the behavior here?
                    // draw 從每個 shape 建立線物件陣列，並將其傳回 shape 行繪製，exposing the internals of the Shape class
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (format.equals("png")) {
            try (Writer writer = new PNGWriter(filename + ".png")) {
                for (Shape shape : this.shapes) {
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // public void draw(String format, String filename) {
    //     try (Writer writer = WriterFactory.getWriter(format, filename)) {
    //         drawShapes(writer);
    //     } catch (IOException | UnsupportedFormatException e) {
    //         e.printStackTrace();
    //     }
    // }

    // private void drawShapes(Writer writer) throws IOException {
    //     for (Shape shape : this.shapes) {
    //         shape.draw(writer);
    //     }
    // }
}

