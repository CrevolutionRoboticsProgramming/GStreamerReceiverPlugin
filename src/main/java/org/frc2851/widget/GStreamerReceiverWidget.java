package org.frc2851.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import org.frc2851.data.Placeholder;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.nio.ByteBuffer;


@Description(
        name = "GStreamer Receiver Widget",
        dataTypes = Placeholder.class
)
@ParametrizedController("GStreamerReceiverPlugin.fxml")
public class GStreamerReceiverWidget extends SimpleAnnotatedWidget<Placeholder>
{
    @FXML
    private Pane root;
    @FXML
    private ImageView imageView;

    private VideoCapture capture = new VideoCapture("udpsrc port=1181 ! application/x-rtp,encoding-name=JPEG,payload=26 ! rtpjpegdepay ! jpegdec ! videoconvert ! video/x-raw,format=BGR ! appsink", Videoio.CAP_GSTREAMER);
    private Mat frame;
    private byte[] data = new byte[240 * 320 * 3];
    private ByteBuffer buffer = ByteBuffer.wrap(data);

    @Override
    public Pane getView()
    {
        if (capture.grab())
            capture.read(frame);
        else
            return root;

        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2RGB);
        frame.get(0, 0, data);

        WritableImage image = new WritableImage(frame.cols(), frame.rows());
        image.getPixelWriter().setPixels(0, 0, 320, 240, PixelFormat.getByteRgbInstance(), buffer, 320 * 3);

        imageView.setImage(image);
        root.getChildren().add(imageView);

        return root;
    }
}
