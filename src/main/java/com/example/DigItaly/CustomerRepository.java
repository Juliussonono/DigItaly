package com.example.DigItaly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    List<Customer> findAll();

    /*
    private List<ProfileCustomer> profileCustomers;
    public ProfileCustomerRepository() {

        profileCustomers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            profileCustomers.add(new ProfileCustomer(i, "username"+Integer.toString(i),"firstName"+Integer.toString(i),"lastName"+Integer.toString(i), "email"+Integer.toString(i), "password"+Integer.toString(i), "adress"+Integer.toString(i) ));
        }
    }


    public ProfileCustomer getProfilCustomer(Integer id) {
        for (ProfileCustomer profileCustomer : profileCustomers) {
            if (profileCustomer.getId()==id)  {
                return profileCustomer;
            }
        }
        return null;
    }


    public List<ProfileCustomer> getProfileCustomers() {
        return profileCustomers;
    }


    public void addProfileCustomers(ProfileCustomer profileCustomer) {
        ProfileCustomer lastprofilCustomer = profileCustomers.get(profileCustomers.size()-1);
        profileCustomer.setId(lastprofilCustomer.getId()+1);
        profileCustomers.add(profileCustomer);
    }


    public void editProfileCustomers(ProfileCustomer profileCustomers) {
        ProfileCustomer profileCustomersToEdit = this.getProfilCustomer(profileCustomers.getId());
        if (profileCustomersToEdit != null) {
            profileCustomersToEdit.setFirstName(profileCustomers.getFirstName());
            profileCustomersToEdit.setLastName(profileCustomers.getLastName());
            profileCustomersToEdit.setEmail(profileCustomers.getEmail());
        }
    }


    public void deleteProfileCustomers(Integer id) {
        ProfileCustomer profileCustomersToDelete = this.getProfilCustomer(id);
        if (profileCustomersToDelete != null) {
            profileCustomers.remove(profileCustomersToDelete);
        }
    }*/
}