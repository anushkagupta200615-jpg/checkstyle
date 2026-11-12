/*
FallThrough
checkLastCaseGroup = true
reliefPattern = (default)falls?[ -]?thr(u|ough)


*/

package com.puppycrawl.tools.checkstyle.checks.coding.fallthrough;

public class InputFallThrough
{
    void methodFallThruLastCaseGroup(int i) {
        while (true) {
            switch (i){
            case 0:
                i++; // fallthru
            }
            switch (i){
            case 0:
                i++;
                // fallthru
            }
            switch (i){
            case 0:
                i++;
            /* fallthru */ }
        }
    }

    void testLastCaseGroupViolation(int i) {
        switch (i) {
            case 0:
                i++;
                break;
            case 1: // violation 'Fall .* from the last branch of the switch statement.'
                i++;
        }
        switch (i) {
            case 0:
                i++;
                break;
            case 1:
                i++;
                break;
        }
    }

    /* C-style comments with custom fallthru-comment and checkLastCaseGroup=true. */
    void methodFallThruCCustomWords(int i) {
        while (true) {
            switch (i){
            case 0:
                i++; /* Continue with next case */

            case 1: // violation 'Fall\ through from previous branch of the switch statement.'
                i++;
            /* Continue with next case */
            case 2: // violation 'Fall\ through from previous branch of the switch statement.'
                i++;
            /* Continue with next case */case 3: // violation 'Fall\ through from prev.*'
                  break;
            case 4: // violation 'Fall .* from the last branch of the switch statement.'
                i++;
            /* Continue with next case */
            }
        }
    }
}
