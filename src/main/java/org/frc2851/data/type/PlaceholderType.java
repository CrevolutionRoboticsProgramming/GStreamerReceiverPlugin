package org.frc2851.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import org.frc2851.data.PlaceholderData;

import java.util.Map;
import java.util.function.Function;

/**
 * Represents data of the {@link PlaceholderData} type.
 */
public final class PlaceholderType extends ComplexDataType<PlaceholderData>
{
    public static final PlaceholderType Instance = new PlaceholderType();
    private static final String TYPE_NAME = "PlaceholderData";

    private PlaceholderType()
    {
        super(TYPE_NAME, PlaceholderData.class);
    }

    @Override
    public Function<Map<String, Object>, PlaceholderData> fromMap()
    {
        return map -> new PlaceholderData();
    }

    @Override
    public PlaceholderData getDefaultValue()
    {
        return new PlaceholderData();
    }
}
