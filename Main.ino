#include <NewPing.h>
#include <NewServo.h>
#include <QTRSensors.h>
#include <ZumoReflectanceSensorArray.h>
#include <ZumoMotors.h>
#include <PLab_ZumoMotors.h>
#include <SoftwareSerial.h>
#include <PLabBTSerial.h>


#define rxPin 1
#define txPin 2

const int echoPin = A1;
const int triggerPin = A0;
const int maxDistance = 30;
const int servoPin = 6;

int forwardSpeed = 400;
int backwardSpeed = 200;
int turnSpeed = 200;

int degreesServo = 0;
int degreesStep = 5;

PLab_ZumoMotors motor;
NewPing sonar(triggerPin, echoPin, maxDistance);
NewServo myServo;
PLabBTSerial btSerial(txPin, rxPin);

void stepServo() {
   degreesServo = degreesServo + degreesStep;
   if (degreesServo > 180) {
       degreesStep = -degreesStep;
       degreesServo = 180;
   } else if (degreesServo < 0) {
       degreesStep = -degreesStep;
       degreesServo = 0;
   } 

   if (degreesServo < 65) {
      motor.turnRight(turnSpeed, 10);
   } else {
      motor.turnLeft(turnSpeed, 10);
   }
   myServo.write(degreesServo);
}

void searchMode() {
  stepServo();
}

void readCommand() {
  int availableCount = btSerial.available();
  if (availableCount > 0) {
    char text[availableCount];
    btSerial.read(text, availableCount); 
    Serial.println(text);
  }
}


void attackMode() {

     if (degreesServo > 65) {
         motor.turnLeft(forwardSpeed,degreesServo-65);
      } else if (degreesServo < 65) {
        motor.turnRight(forwardSpeed,65-degreesServo);
      };
      degreesServo = 65;
      myServo.write(degreesServo);
        //Serial.println(sonar.ping());
       motor.forward(forwardSpeed, 20);
    

}

void setup() {
  Serial.begin(9600);
  btSerial.begin(9600);
  myServo.attach(servoPin); 
  myServo.write(90);

}

void loop() {
  //Serial.println(checkDistance());
  readCommand();
  //if (checkDistance()) {
    //attackMode();
  //} else {
   // searchMode();
 //}

}
