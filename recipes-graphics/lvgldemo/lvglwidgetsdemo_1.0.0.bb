SUMMARY = "make project for LVGL Widgets Demo"
DESCRIPTION = "recipe for building the full lvgl widgets demo"
RECIPE_MAINTAINER = "Atanas Rusev <atanasr@triplehelix-consulting.com>"
HOMEPAGE = "https://triplehelix-consulting.com"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

SMGIT = "lvgl_demo_widgets"
IMDIR = "lvgl_demo_widgets"
IMBIN = "lvglWidgets"

PV .= "+git${SRCPV}"
SRCREV = "456425ecdb76ee054790a21c72d4c1d779271c39"


#https://docs.yoctoproject.org/ref-manual/variables.html#term-BPN
#
SRC_PATH = "${FILE_DIRNAME}/${BPN}"
SRC_URI = "git://github.com/AtanasRusevTH/${SMGIT}.git;branch=main;protocol=https"

DEPENDS = "libsdl2"

#DEPENDS:remove = "mesa"

# https://docs.yoctoproject.org/ref-manual/variables.html#term-S
# The location in the Build Directory where unpacked recipe source code resides. By default, this directory is ${WORKDIR}/${BPN}-${PV}, where ${BPN} is the base recipe name and ${PV} is the recipe version. If the source tarball extracts the code to a directory named anything other than ${BPN}-${PV}, or if the source code is fetched from an SCM such as Git or Subversion, then you must set S in the recipe so that the OpenEmbedded build system knows where to find the unpacked source.
S = "${WORKDIR}/git"

FILES:${PN}:append = " ${ROOT_HOME}"
# LDFLAGS = -Wl,--hash-style=gnu
# LDFLAGS = -Wl,--hash $(inherited)

# inherit pkgconfig
# inherit cmake thclass pkgconfig
# https://docs.yoctoproject.org/bitbake/2.0/bitbake-user-manual/bitbake-user-manual-metadata.html#inherit-directive
# inherit make
# https://docs.yoctoproject.org/dev-manual/new-recipe.html#building-a-makefile-based-package

#do_compile() {
#	cd ${S}
#	make
#}
#Dev Manual : New recipe: https://docs.yoctoproject.org/4.2.1/dev-manual/new-recipe.html

#EXTRA_OEMAKE = "PREFIX=${prefix} CC='${CC}' CFLAGS='${CFLAGS}' DESTDIR=${D} LIBDIR=${libdir} INCLUDEDIR=${includedir} BUILD_STATIC=no"

do_install() {
#	install -d ${D}/${bindir}
	install -d ${D}/${ROOT_HOME}
#	install -m 0755 ${B}/${IMBIN} ${D}/${bindir}
	install -m 0755 ${B}/${IMBIN} ${D}/${ROOT_HOME}
#	oe_runmake install
}

