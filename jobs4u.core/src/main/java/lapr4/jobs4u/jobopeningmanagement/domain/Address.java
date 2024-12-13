/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package lapr4.jobs4u.jobopeningmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address implements ValueObject {

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String state;

    public Address(final String street, final String city, final String state) {
        if (StringPredicates.isNullOrWhiteSpace(street) || StringPredicates.isNullOrWhiteSpace(city) || StringPredicates.isNullOrWhiteSpace(state)) {
            throw new IllegalArgumentException(
                    "Any of the Address parameters should neither be null nor empty");
        }
        this.street = street;
        this.city = city;
        this.state = state;
    }

    protected Address() {
        // for ORM
    }

    public String street() {
        return street;
    }

    public String city() {
        return city;
    }

    public String state() {
        return state;
    }

    public static Address valueOf(final String street, final String city, final String state) {
        return new Address(street, city, state);
    }

    @Override
    public String toString() {
        return "Address: Street->" + this.street + " City->" + this.city + " State->" + this.state;
    }

}
