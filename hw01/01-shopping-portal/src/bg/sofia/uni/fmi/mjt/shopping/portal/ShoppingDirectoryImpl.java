package bg.sofia.uni.fmi.mjt.shopping.portal;

import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.NoOfferFoundException;
import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.OfferAlreadySubmittedException;
import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.ProductNotFoundException;
import bg.sofia.uni.fmi.mjt.shopping.portal.offer.Offer;

import java.time.LocalDate;
import java.util.*;

public class ShoppingDirectoryImpl implements ShoppingDirectory {

    private Set<Offer> allOffers = new HashSet<>();
	
    @Override
    public Collection<Offer> findAllOffers(String productName) throws ProductNotFoundException {
        if (productName == null) {
            throw new IllegalArgumentException("Please, provide correct data!");
        } else {
            int counter = 0;
            for (Offer offer : this.allOffers) {
                if (!productName.equals(offer.getProductName())) {
                    counter++;
                }
            }
            if (counter == this.allOffers.size()) {
                throw new ProductNotFoundException("The product with this name is not found!");
            } else {
                LocalDate currentMonth = LocalDate.now();
                Set<Offer> currentMonthOffers = new HashSet<>();
                for (Offer offer : this.allOffers) {
                    if (offer.getDate().getMonth().compareTo(currentMonth.getMonth()) == 0) {
                        currentMonthOffers.add(offer);
                    }
                }
                ArrayList<Offer> listOffers = new ArrayList<>(currentMonthOffers);
                listOffers.sort(Comparator.comparing(Offer::getTotalPrice));
                currentMonthOffers.addAll(listOffers);
                return currentMonthOffers;
            }
        }
    }

    @Override
    public Offer findBestOffer(String productName) throws ProductNotFoundException, NoOfferFoundException {
        if (productName == null) {
            throw new IllegalArgumentException("Please, provide correct data!");
        } else {
            int counter1 = 0;
            int counter2 = 0;
            LocalDate currentMonth = LocalDate.now();
            for (Offer offer : this.allOffers) {
                if (!productName.equals(offer.getProductName())) {
                    counter1++;
                }
                if (productName.equals(offer.getProductName())) {
                    if (offer.getDate().getMonth().compareTo(currentMonth.getMonth()) == 0) {
                        counter2++;
                    }
                }
            }
            if (counter1 == this.allOffers.size()) {
                throw new ProductNotFoundException("The product with this name is not found!");
            } else if (counter2 == 0) {
                throw new NoOfferFoundException("There is no offer submitted int the last 30 days for this product!");
            } else {
                Set<Offer> favouriteOffers = new HashSet<>();
                for (Offer offer : this.allOffers) {
                    if (productName.equals(offer.getProductName())) {
                        favouriteOffers.add(offer);
                    }
                }
                ArrayList<Offer> listOffers = new ArrayList<>(favouriteOffers);
                listOffers.sort(Comparator.comparing(Offer::getTotalPrice));
                return listOffers.get(0);
            }
        }
    }

    @Override
    public Collection<PriceStatistic> collectProductStatistics(String productName) throws ProductNotFoundException {
        if (productName == null) {
            throw new IllegalArgumentException("Please, provide correct data!");
        } else {
            int counter = 0;
            for (Offer offer : this.allOffers) {
                if (!productName.equals(offer.getProductName())) {
                    counter++;
                }
            }
            if (counter == this.allOffers.size()) {
                throw new ProductNotFoundException("The product with this name is not found!");
            } else {
                return null;
            }
        }
    }

    @Override
    public void submitOffer(Offer offer) throws OfferAlreadySubmittedException {
        if (offer == null) {
            throw new IllegalArgumentException("Please, provide correct data!");
        } else {
            if (this.allOffers.contains(offer)) {
                throw new OfferAlreadySubmittedException("This offer already exists!");
            }
            this.allOffers.add(offer);
        }
    }
}
