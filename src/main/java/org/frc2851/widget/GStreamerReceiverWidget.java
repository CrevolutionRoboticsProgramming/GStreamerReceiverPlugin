package org.frc2851.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.frc2851.data.PlaceholderData;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.io.IOException;
import java.nio.ByteBuffer;

@Description(
        name = "GStreamer Receiver Widget",
        dataTypes = PlaceholderData.class
)
@ParametrizedController("GStreamerReceiverPlugin.fxml")
public class GStreamerReceiverWidget extends Application implements Runnable//SimpleAnnotatedWidget<PlaceholderData>
{
    @FXML
    private VBox root;
    @FXML
    private ImageView imageView;

    private static VideoCapture capture;
    private static byte[] data = new byte[240 * 320 * 3];
    private static ByteBuffer buffer = ByteBuffer.wrap(data);

    private Thread thread = new Thread(this);

    @FXML
    public void initialize()
    {
        thread.start();
    }
/*
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        launch(args);
    }
*/
    @Override
    public void start(Stage stage)
    {
        stage.setOnCloseRequest(e ->
                System.exit(0));

        Scene scene = null;
        try
        {
            scene = new Scene(FXMLLoader.load(getClass().getResource("GStreamerReceiverPlugin.fxml")));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        stage.setTitle("Vision Communicator");
        stage.setScene(scene);
        stage.show();
    }

    //@Override
    public Pane getView()
    {
        return root;
    }

    @Override
    public void run(){}
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        capture = new VideoCapture("udpsrc port=1181 ! application/x-rtp,encoding-name=JPEG,payload=26 ! rtpjpegdepay ! jpegdec ! videoconvert ! appsink", Videoio.CAP_GSTREAMER);
        if (!capture.isOpened())
        {
            System.out.println("Could not open capture");
            return;
        }
        Mat frame = new Mat();

        //final Timeline imageUpdater = new Timeline(
        //        new KeyFrame(Duration.ZERO, event ->
         while (true)
         {
             if (!capture.grab())
                 return;

             capture.read(frame);
             HighGui.imshow("Frame", frame);
             HighGui.waitKey(1);

             Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2RGB);
             frame.get(0, 0, data);

             WritableImage image = new WritableImage(frame.cols(), frame.rows());
             image.getPixelWriter().setPixels(0, 0, 320, 240, PixelFormat.getByteRgbInstance(), buffer, 320 * 3);

             //imageView.setImage(image);
             //       }),
             //new KeyFrame(Duration.millis(100))
             //);
             //imageUpdater.setCycleCount(Timeline.INDEFINITE);
         }
        //imageUpdater.play();
    }
}
