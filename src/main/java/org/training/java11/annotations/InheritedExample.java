package org.training.java11.annotations;

import java.lang.annotation.Inherited;

//@interface BreatheInWater{}
@Inherited
@interface BreatheInWater{} // this is an inheritable annotation

@BreatheInWater class Fish{}

class Trout extends Fish{}

public class InheritedExample {

}