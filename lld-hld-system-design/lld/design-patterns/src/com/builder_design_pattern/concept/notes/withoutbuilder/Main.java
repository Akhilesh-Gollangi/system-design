//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    UserProfile u1 = new UserProfile("Mainak",
            "mainakgh1@gmail.com",
            28, "9810101010",
            "test",
            "delhi",
            "UP",
            true,
            true); // pain point 1 : keep checking the actual class for the order of items


    UserProfile u2 = new UserProfile("Sahas",
            "mainakgh1@gmail.com",
            28, "9810101010",
            "test",
            "delhi",
            "UP",
            true,
            true);


    UserProfile u3 = new UserProfile("Amruta",
            "mainakgh1@gmail.com",
            28, "9810101010",
            "test",
            "delhi",
            "UP",
            true,
            true);


    UserProfile u4 = new UserProfile("Kotari",
            "mainakgh1@gmail.com",
            28, "9810101010",
            "test",
            "delhi",
            "UP",
            true,
            true); // pain point 2 : if the order of the params in the constructor change, then if you have to fix it everywhere



}
