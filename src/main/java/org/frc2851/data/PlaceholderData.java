package org.frc2851.data;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;

public final class PlaceholderData extends ComplexData<PlaceholderData>
{
    public PlaceholderData()
    {
    }

    @Override
    public Map<String, Object> asMap()
    {
        return Map.of();
    }
}
