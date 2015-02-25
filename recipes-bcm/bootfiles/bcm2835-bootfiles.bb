DESCRIPTION = "Closed source binary files to help boot the ARM on the BCM2835."
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://Broadcom;md5=957f6640d5e2d2acfce73a36a56cb32f"

inherit deploy

include ../common/firmware.inc

RDEPENDS_${PN} = "rpi-config"

COMPATIBLE_MACHINE = "raspberrypi"

S = "${RPIFW_S}/boot"

PR = "r3"

do_deploy() {
    install -d ${DEPLOYDIR}/${PN}

    for i in ${S}/*.elf ; do
        cp $i ${DEPLOYDIR}/${PN}
    done
    for i in ${S}/*.dat ; do
        cp $i ${DEPLOYDIR}/${PN}
    done
    for i in ${S}/*.bin ; do
        cp $i ${DEPLOYDIR}/${PN}
    done

    # Add stamp in deploy directory
    touch ${DEPLOYDIR}/${PN}/${PN}-${PV}.stamp
}

addtask deploy before do_package after do_install
do_deploy[dirs] += "${DEPLOYDIR}/${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

