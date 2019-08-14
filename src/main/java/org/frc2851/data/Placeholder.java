package org.frc2851.data;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;

public final class Placeholder extends ComplexData<Placeholder>
{
    public Placeholder()
    {}

    @Override
    public Map<String, Object> asMap()
    {
        return Map.of();
    }
}
