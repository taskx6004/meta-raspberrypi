SRCREV = "e677699247ed7f766bd1d16f69436ab8e14fdec9"
SRC_URI = "git://github.com/emlid/linux-rt-rpi.git;protocol=git;branch=rpi-3.12.36-rt50+ \
           file://sl030raspberrypii2ckernel.patch \
          "

require linux-raspberrypi.inc
