boolean checkDistance() {
  unsigned int time = sonar.ping();
  Serial.println(time);
  return time > 0;
}
