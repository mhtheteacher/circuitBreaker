# circuitBreaker
Demo of circuit breaker pattern in Rest Api using Resilience4j

This student service calls another service for listing available courses to the student. 
However, if the Course service is unavailable then the student service will retry as per the configuration in yml file if it crosses the failure threshold 
then fall back method is invoked temporarily till the Courses service becomes available.
