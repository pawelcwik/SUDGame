package pl.com.clockworkgnome.sudgame.domain;


public enum Direction {
    N("north"),S("south"),E("east"),W("west"),D("down"),U("up");
    
    private String directionDescription;

    private Direction(String directionDescription) {
        this.directionDescription = directionDescription;      
    }
    
    @Override
    public String toString() {
        return directionDescription;
    }
    
    
    
    
}
