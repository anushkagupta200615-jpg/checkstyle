/*
FallThrough
checkLastCaseGroup = (default)false
reliefPattern = (default)falls?[ -]?thr(u|ough)


*/

package com.puppycrawl.tools.checkstyle.checks.coding.fallthrough;

public class InputFallThroughDefaultSpecialCases
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

    void method1472228(int i) {
        switch(i) {
        case 2:
            // do nothing
            break;
        default:
        }
    }

    void nestedSwitches() {
        switch (hashCode()) {
            case 1:
                switch (hashCode()) { // causing NullPointerException in the past
                    case 1:
                }
            default: // violation 'Fall\ through from previous branch of the switch statement.'
        }
    }

    void nextedSwitches2() {
        switch(hashCode()) {
        case 1:
            switch(hashCode()){}
        case 2: // violation 'Fall\ through from previous branch of the switch statement.'
            System.lineSeparator();
            break;
        }
    }

    void ifWithoutBreak() {
        switch(hashCode()) {
        case 1:
            if (true) {
                System.lineSeparator();
            }
        case 2: // violation 'Fall\ through from previous branch of the switch statement.'
            System.lineSeparator();
            break;
        }
    }

    void noCommentAtTheEnd() {
        switch(hashCode()) {
        case 1: System.lineSeparator();
        case 2: // violation 'Fall\ through from previous branch of the switch statement.'
            System.lineSeparator();
            break;
        }
    }

    void synchronizedStatement() {
       switch (hashCode()) {
           case 1:
               synchronized (this) {
                   break;
               }
           case 2:
               if (true) {
                   synchronized (this) {
                       break;
                   }
               } else {
                   synchronized (this) {
                       break;
                   }
               }
           case 3:
               synchronized (this) {
               }
               // fallthru
           default:
               break;
       }
    }

    void multipleCasesOnOneLine() {
        int i = 0;
        switch (i) {
        case 0: case 1: i *= i;
        case 2: case 3: i *= i; // violation 'Fall\ through from prev.* br.* switch statement.'
        case 4: case 5: i *= i; // violation 'Fall\ through from prev.* br.* switch statement.'
        case 6: case 7: i *= i; // violation 'Fall\ through from prev.* br.* switch statement.'
            break;
        default:
            throw new RuntimeException();
        }
    }
}
