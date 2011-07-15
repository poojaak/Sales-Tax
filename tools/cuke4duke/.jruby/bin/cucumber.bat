@ECHO OFF
IF NOT "%~f0" == "~f0" GOTO :WinNT
@"jruby-complete-1.6.0.jar" "c:/Users/poojaak/Sales-Tax/tools/cuke4duke/.jruby/bin/cucumber" %1 %2 %3 %4 %5 %6 %7 %8 %9
GOTO :EOF
:WinNT
@"jruby-complete-1.6.0.jar" "%~dpn0" %*
