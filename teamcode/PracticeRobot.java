package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PracticeRobot {

    public DcMotor dcRight;
    public DcMotor dcLeft;
    private Servo servo;
    private double servo1;
    private double servo2;
    private double servo3;
    private double servoPosition;
    public ElapsedTime runtime = new ElapsedTime();
    public double initialRunTime;
    public int iterations=0;
    private double ITERATIONS_PER_SECOND;
    //initialize(before constructor) and hardwaremap(in constructor) 2 dcmotor, 1 servo, 3 double servo positions
    //3 method for moving servo to each position
    //1 for toggle between



    //figure out a way to increment a servo every iteration at a speed of 1 full servo movement(0 to 1) every 3 seconds
    //you will have to use runtime
    private final HardwareMap hardwareMap;


    private final Telemetry telemetry;




    public PracticeRobot(HardwareMap _hm, Telemetry _tm){
        hardwareMap=_hm;
        telemetry=_tm;
        dcRight = hardwareMap.dcMotor.get("right");
        dcLeft = hardwareMap.dcMotor.get("left");
        servo = hardwareMap.servo.get("servo");
        initialRunTime=runtime.seconds();
        up();
        servoPosition=servo.getPosition();
    }

    public void up(){
        servo.setPosition(servo1);
        servoPosition=servo.getPosition();
    }
    public void down(){
        servo.setPosition(servo2);
        servoPosition=servo.getPosition();
    }
    public void middle(){
        servo.setPosition(servo3);
        servoPosition=servo.getPosition();
    }
    public void toggle(){
        if(servo.getPosition() == servo2 )
            middle();
        else if(servo.getPosition() == servo1)
            down();
        else
            up();
    }

    public void serVelocity(boolean movingUp){
        ITERATIONS_PER_SECOND=iterations/(runtime.seconds()-initialRunTime);

        if(movingUp)
            servoPosition=Math.min(servoPosition+(1/3.0)*1/(ITERATIONS_PER_SECOND),1);
        else
            servoPosition=Math.max(servoPosition-(1/3.0)*1/(ITERATIONS_PER_SECOND),0);
        servo.setPosition(servoPosition);
    }


}
