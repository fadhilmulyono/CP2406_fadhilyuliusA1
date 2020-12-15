public class Car {
    private static final int STOPPED = 0; // when car is stopped, set speed to 0 m/s
    private static final int NEXT_ROAD_INDEX = 0; // set the index of next road
    private static final int START_POSITION = 1; // set the start position
    String id; // unique identifier for each car
    static float length; // number of segments occupied, 1 for ease of prototype.
    private static float width;
    private int speed; // segments moved per turn
    private int position; // position on current road
    private Road currentRoad; // current Road object


    public Car(String id, Road currentRoad) {
        this.id = "car_" + id;
        this.currentRoad = currentRoad;
        length = 1f; // cars made 1m long.
        width = length * 0.5f;
        speed = 0;
        position = 1;
        this.currentRoad.getCarsOnRoad().add(this); //add this car to the road it drives on.
    }

    public Car() {
        id = "0";
        length = 1f;
        width = length * 0.5f;
        speed = 0;
        position = 1;
    }

    public void move() {
        this.speed = this.currentRoad.getSpeedLimit(); //set speed limit to that of currentRoad
        if (!this.currentRoad.getLightsOnRoad().isEmpty() && this.position == this.currentRoad.getLightsOnRoad().get(0).getPosition() && this.currentRoad.getLightsOnRoad().get(0).getState().equals("red")) {
            this.speed = STOPPED;
        } else {
            this.speed = this.currentRoad.getSpeedLimit();
            if (this.currentRoad.getLength() == this.getPosition() && !this.currentRoad.getConnectedRoads().isEmpty()) {
                this.currentRoad.getCarsOnRoad().remove(this);
                this.currentRoad = this.currentRoad.getConnectedRoads().get(NEXT_ROAD_INDEX);
                this.currentRoad.getCarsOnRoad().add(this);
                this.position = START_POSITION;
            } else if (this.currentRoad.getLength() > this.getPosition()) {
                this.position = (this.position + this.speed);
            } else {
                this.speed = STOPPED;
            }
        }
    }

    public void printCarStatus() {
        System.out.printf("%s going:%dm/s on %s at position:%s%n", this.getId(), this.getSpeed(), this.getCurrentRoad().
                getId(), this.getPosition());
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        Car.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        Car.width = width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Road getCurrentRoad() {
        return currentRoad;
    }

    public void setCurrentRoad(Road currentRoad) {
        this.currentRoad = currentRoad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
