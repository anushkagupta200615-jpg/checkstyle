/*
FallThrough
checkLastCaseGroup = (default)false
reliefPattern = Continue with next case


*/

package com.puppycrawl.tools.checkstyle.checks.coding.fallthrough;

public class InputFallThrough3
{
    /* C-style comments with custom fallthru-comment. */
    void methodFallThruCCustomWords(int i) {
        while (true) {
            switch (i){
            case 0:
                i++; /* Continue with next case */

            case 1:
                i++;
            /* Continue with next case */
            case 2:
                i++;
            /* Continue with next case */case 3:
                  break;
            case 4:
                i++;
            /* Continue with next case */
            }
        }
    }

    /* Standard relief comments are NOT recognized by this pattern. */
    void methodDefaultReliefCommentsFail(int i) {
        switch (i) {
            case 0:
                i++;
                // fallthru
            case 1: // violation 'Fall\ through from previous branch of the switch statement.'
                i++;
                /* falls through */
            case 2: // violation 'Fall\ through from previous branch of the switch statement.'
                i++;
                break;
            default:
                break;
        }
    }
}
