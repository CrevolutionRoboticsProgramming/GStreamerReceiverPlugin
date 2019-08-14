package org.frc2851;

import com.google.common.collect.ImmutableList;
import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import org.frc2851.data.type.PlaceholderType;
import org.frc2851.widget.GStreamerReceiverWidget;

import java.util.List;

@Description(
        group = "org.frc2851",
        name = "GStreamerReceiverPlugin",
        version = "0.0.1",
        summary = "Displays the camera feed captured by GStreamer"
)
public class GStreamerReceiverPlugin extends Plugin
{
    @Override
    public List<ComponentType> getComponents()
    {
        return List.of(
                WidgetType.forAnnotatedWidget(GStreamerReceiverWidget.class)
        );
    }

    @Override
    public List<DataType> getDataTypes()
    {
        return ImmutableList.of(
                PlaceholderType.Instance
        );
    }
}
