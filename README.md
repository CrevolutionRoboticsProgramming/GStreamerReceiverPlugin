# GStreamerReceiverPlugin

### Crevolution's client-side ShuffleBoard plugin for receiving a GStreamer MJPG stream via UDP from our [OffseasonVision2019](https://github.com/CrevolutionRoboticsProgramming/OffseasonVision2019) vision processing program

## Purpose

This application receives the video stream sent by our [OffseasonVision2019](https://github.com/CrevolutionRoboticsProgramming/OffseasonVision2019) vision processing program, draws a line down the middle, and displays it in a ShuffleBoard widget.

## Usage

Run .\gradlew deployWidget to move the .jar to your ShuffleBoard plugins directory. You'll need a custom-built OpenCV instance with Java and GStreamer support included in your shuffleboard.jar file for this to run, which is a pain to build. Open ShuffleBoard and create a new instance of the widget in your window. Not gonna lie, it kinda sucks. Our [GStreamerViewer](https://github.com/CrevolutionRoboticsProgramming/GStreamerViewer) project accomplishes the same thing, but a lot faster and without ShuffleBoard.
