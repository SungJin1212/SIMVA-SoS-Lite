package cleaningSoSModel.model.strc;

import cleaningSoSModel.model.behv.*;
import kr.ac.kaist.se.model.strc.SoS;
import kr.ac.kaist.se.simdata.output.intermediate.RunResult;
import kr.ac.kaist.se.simdata.output.intermediate.UpdateResult;

public class SweepingRobot extends Robot {

    public SweepingRobot(SoS sos, int x, int y, String name) {
        super(sos, x, y);
        this.name = name;
        this.addAction(new Sweeping(this));
    }

    @Override
    public void selectActions(){
        doDecisionMaking();
    }

    @Override
    public void doDecisionMaking() {
        double random = Math.random();
        if (random < 0.125) {
            this.addSelectedAction(new MovingUp(this));
        }
        else if (random < 0.25) {
            this.addSelectedAction(new MovingDown(this));
        }
        else if (random < 0.375) {
            this.addSelectedAction(new MovingLeft(this));
        }
        else if (random < 0.5) {
            this.addSelectedAction(new MovingRight(this));
        }
        else {
            this.addSelectedAction(new Sweeping(this));
        }
    }

    @Override
    public void changeState() {

    }

    @Override
    public UpdateResult update(RunResult runResult) {
        UpdateResult updateResult = super.update(runResult);
        updateResult.addLog(this.location.getX() + ", " + this.location.getY());
        return updateResult;
    }
}
