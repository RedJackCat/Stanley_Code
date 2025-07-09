/*
ControllerButtons.java
Written by CoPokBl

This contains the IDs of all the buttons on the controller.
Controller: Logitech Gamepad F310
*/

package com.disastrousdata.controllers;


public enum ControllerButtons implements Controller {
    A(1),
    B(2),
    X(3),
    Y(4),
    LEFT_BUMPER(5),
    RIGHT_BUMPER(6),
    BACK(7),
    START(8),
    LEFT_STICK(9),
    RIGHT_STICK(10);

    public final int buttonId;

    ControllerButtons(int id) {
        this.buttonId = id;
    }

    @Override
    public int getButtonId() {
        return buttonId;
    }

      /** Represents an axis on an XboxController. */
    public enum Axis {
        /** Left X axis. */
        LeftX(0),
        /** Right X axis. */
        RightX(4),
        /** Left Y axis. */
        LeftY(1),
        /** Right Y axis. */
        RightY(5),
        /** Left trigger. */
        LeftTrigger(2),
        /** Right trigger. */
        RightTrigger(3);
        

        /** Axis value. */
        public final int value;

        Axis(int value) {
            this.value = value;
        }

    }
}
