# Java Based Traffic Simulator - Prototype Console-based Version
## Program Working Document

### Specification
The client, specifically for the people who are learning to drive after getting their driving licenses, needs a medium of learning about the traffic in city areas.
Learning about the traffic is necessary to learn about the safety and the rules of the traffic when driving their vehicles.
Therefore, this Traffic Simulator program is specifically designed to help people learn about the vehicles' behaviour on the road interacting with intersections, traffic lights and other vehicles.
This prototype is a console-based program that takes inputs from the user, simulating a single car moving along a single lane road and having the aforementioned interaction behaviours.
The simulated car interacts with the traffic light, which will stop when the light is red and moves to the second road connected to the first road when the light is green.

### Decomposition
The problem is broken into several objects, which consist of the following classes:

#### Car
Describes an average sized road vehicle, having the following attributes:
- ID: Unique identifier of the car
- Length: The length of the car
- Width: The width is half of the length of the car
- Speed: The rate in which the car moves in each turn
- Position: Where the car is located on the road
- Current Location: In which road the car is located

The car moves using the Move() method, depending on the speed defined by the user as well as the speed limit.
The car stops when the traffic light is red, and the car will move to the next road when the traffic light is green.
The simulation ends when the car's position is equal to the End Position of the road.

##### Bus
Describes a large sized road vehicle, inheriting all the Car attributes except that the length is three times the length of a Car class.

##### Motorbike
Describes a small sized road vehicle, inheriting all the Car attributes except that the length is half of the length of a Car class.

#### Road
Describes a single lane road, having the following attributes:
- ID: Unique identifier of the road
- Speed Limit: Maximum speed a car may travel at
- Length: The length of the road
- Start Position: Where the road begins
- End Position: Where the road ends
- Connected Roads: Other roads that physically connect the road
- Lights on Road: How many traffic lights are on the road
- Cars on Road: How many cars are traveling on the road

In this prototype, the speed is constant and therefore always set to 1. making for the car easier to deal with traffic lights and ends of the roads.
The length of the road is variable depending on the user input.
Roads interact with other roads by connecting them, creating a simple intersection.
Cars move from the Start Position to the End Position of the road.
Traffic lights can only be placed in the End Positions on the road.

#### Traffic Light
Describes a traffic light, having the following attributes:
- ID: Unique identifier of the traffic light
- State: What colour is the traffic light (red/green)
- Position: Where the traffic light is located on the road
- Road Attached To: In which road the traffic light is attached to

The traffic light operates using the Operate() method.
The traffic light randomly change from green to red, and vice versa using randomly generated pseudo-numbers.
The traffic light can only be placed at the end of each road and will interact with the cars in that position.
The car stops when the traffic light is red, and the car will move to the next road when the traffic light is green.

### Main
The Main class contains the simulation loop.
All the objects needed for the simulation (roads, cars and traffic lights) are created using this class.
Locations of the roads and their connections are also set using this class.
In this prototype, the user only have control on the road length and the constant speed of 1.
Once the setup finishes, the car will move along the road and interacting with operating traffic lights, until the car stops at the End Position of the road.

