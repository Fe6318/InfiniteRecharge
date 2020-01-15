package frc.robot.utilities;
import java.util.ArrayList;

public class PIDOutputGroup implements PIDOutput
{
    private ArrayList<VictorPIDOutput> m_outputs;

    public PIDOutputGroup(ArrayList<VictorPIDOutput> outputs)
    {
        m_outputs = outputs;
    }

	@Override
	public void PIDWrite(double output) {
        for(int i = 0; i < m_outputs.size(); i++)
        {
            m_outputs.get(i).PIDWrite(output);

        }
	}
}