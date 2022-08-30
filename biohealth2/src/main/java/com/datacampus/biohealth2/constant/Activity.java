package com.datacampus.biohealth2.constant;

public enum Activity {

        hyperactivity("hyperactivity"),
        activity("activity"),
        normal("normal"),
        lowActivity("lowActivity");

        private final String activityState;

        Activity(String activityState){
                this.activityState = activityState;
        }

        public String getActivityState(){
                return activityState;
        }

}
