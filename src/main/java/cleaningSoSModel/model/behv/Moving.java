package cleaningSoSModel.model.behv;

import cleaningSoSModel.model.geo.CleaningSoSObjectLocation;
import cleaningSoSModel.model.strc.Robot;
import kr.ac.kaist.se.model.behv.Action;

public abstract class Moving extends Action {
    private Robot target;
    private int xDiff;
    private int yDiff;

    public Moving(Robot target, int xDiff, int yDiff){
        this.name = "Moving " + target.getName();
        this.target = target;
        this.xDiff = xDiff;
        this.yDiff = yDiff;
    }

    @Override
    public float calcUtility(){
        return 0;
    }

    @Override
    public void executeAction(){
        CleaningSoSObjectLocation curLoc = target.getLocation();
        curLoc.setX(curLoc.getX() + xDiff);
        curLoc.setY(curLoc.getY() + yDiff);
    }

    @Override
    public boolean checkPrecondition(){
        return true;
    }
}
