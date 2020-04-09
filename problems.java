public class problems {

    String problems = "(two-pointer *howling* 6)" +
            "(two-pointer *rr* 7)" +
            "(two-pointer *customs* 7)" +
            "(two-pointer *harmonia* 7)" +
            "(two-pointer *myOwnTheorom* 7)";

    String test1 = "(defvar *howling*   " +
                     "'(" +
                            "(1 " +
                            "((howl z) (dog q)) ((hound z) (cat x))) " +
                            "(2 " +
                            "((hound z) (cat x)) ((howl z) (dog q)))" +
                        ")" +
                    ")";;
    String howling =
            "(defvar *howling*   " +
                "'(" +
                    "(1 " +
                        "((howl z)) ((hound z))) " +
                    "(2 " +
                        "nil ((have x y) (cat y) (have x z) (mouse z))) " +
                    "(3 " +
                        "nil ((ls w) (have w v) (howl v))) " +
                    "(4 " +
                        "((have (john) (a))) nil) " +
                    "(5 " +

                        "((cat (a)) (hound (a))) nil) " +
                    "(6 " +
                        "((mouse (b))) nil) " +
                    "(7 " +
                        "((ls (john))) nil) " +
                    "(8 " +
                        "((have (john) (b))) nil)" +
                ")" +
            ")";

    String rr = "(defvar *rr* \t'" +
                    " ( " +
                        "(1   ( (rr (a)) )   \t( (coyote y) )   ) " +
                        "(2\t( (chase z (a)) ) ( (coyote z) )   ) " +
                        "(3   ( (smart x) )   ( (rr x) (beep x) )   ) " +
                        "(4   nil ( (coyote w) (rr u) (catch w u) (smart u) )    ) " +
                        "(5   ( (frustrated s) (catch s t) ) ( (coyote s) (rr t) (chase s t) )    ) " +
                        "(6   ( (beep r) )  ( (rr r) )   ) " +
                        "(7   ( ( coyote (b)) ) nil   )  " +
                        "(8   nil ( (frustrated (b)) )   )    " +
                    "  ) " +
                ")";

    String customs = "(defvar *customs* " +
                        "'( " +
                            "(1 ( (v x) (s x (f x)) ) ( (e x) ) ) " +
                            "(2 ( (v y) (c (f y)) ) ( (e y) ) ) " +
                            "(3 ( (e (a)) ) nil ) " +
                            "(4 ( (d (a)) ) nil ) " +
                            "(5 ( (d z) )   ( (s (a) z) ) ) " +
                            "(6 nil   ( (d w) (v w) ) ) " +
                            "(7 nil  ( (d r) (c r) ) )   " +
                        ")    " +
                      ")";

    String harmonia = "(defvar *Harmonia* "+
                        "'( " +
                            "(1 ( (grandparent x y) ) ( (parent x z) (parent z y) ) ) " +
                            "(2 ( (parent x y) ) ( (mother x y) ) ) " +
                            "(3 ( (parent x y) ) ( (father x y ) ) ) " +
                            "(4 ( (father (zeus) (ares)) ) nil ) " +
                            "(5 ( (mother (hera) (ares)) ) nil )  " +
                            "(6 ( (father (ares) (harmonia)) ) nil ) " +
                            "(7 nil ( (grandparent x (harmonia)) ) )  " +
                        ")   "+
                      ")";

    String myOwnTheorom = "(defvar *customs* " +
                                "'( " +
                                    "(1 ( (hot x) (cold x (f x)) ) ( (shawn x) ) ) " +
                                    "(2 ( (hot y) (shrey (f y)) ) ( (shawn y) ) ) " +
                                    "(3 ( (shawn (a)) ) nil ) " +
                                    "(4 ( (bob (a)) ) nil ) " +
                                    "(5 ( (bob j) )   ( (cold (a) j) ) ) " +
                                    "(6 nil   ( (bob m) (hot m) ) ) " +
                                    "(7 nil  ( (bob o) (shrey o) ) )   " +
                                    ")    " +
                                ")";


        /* HASHMAP
    * 1 - { pl = {(howl z)},nl = {(hound z)} }
    * 2- { pl = {} , nl = {(have x y) , (cat y) ,(have x z) ,(mouse z))} }
    * 3
    * 4 - { pl = {(have (john) (a))} , nl = {} }
    * 5 - { pl = {(cat (a)) , (hound (a))} , nl = {} }
     */

    /**
     * "(1 ( (grandparent x y) ) ( (parent x z) (parent z y) ) ) " +
     *                             "(2 ( (parent x y) ) ( (mother x y) ) ) " +
     *                             3)) pl = (gp x z ) nl= (parent z z ), (mother x z ) ----sl(z /y)
     *                             4) pl = (gp z y ) nl= (parent z y ), (mother z y ) ----sl(z /x)
     */

}
