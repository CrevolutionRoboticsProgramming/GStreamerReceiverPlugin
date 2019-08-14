package org.frc2851.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.util.Maps;
import org.frc2851.data.Placeholder;

import java.util.Map;
import java.util.function.Function;

public class PlaceholderType extends ComplexDataType<Placeholder>
{
    private static final String TYPE_NAME = "Placeholder";
    public static final PlaceholderType Instance = new PlaceholderType();

    private PlaceholderType() {
        super(TYPE_NAME, Placeholder.class);
    }

    @Override
    public Function<Map<String, Object>, Placeholder> fromMap()
    {
        return map -> new Placeholder();
    }

    @Override
    public Placeholder getDefaultValue()
    {
        return new Placeholder();
    }
}
