//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    UserProfile u1 = new UserProfile.Builder()
            .name("Mainak")
            .age(28)
            .email("mainakgh1@gmail.com")
            .phoneNumber("123456789")
            .address("test1")
            .city("test2")
            .isVerified(true)
            .isSubscribedToNewsletter(false)
            .state("UP").build();

}
