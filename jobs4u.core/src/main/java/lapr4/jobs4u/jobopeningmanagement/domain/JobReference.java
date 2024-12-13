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
import jakarta.persistence.Embeddable;

@Embeddable
public class JobReference implements ValueObject, Comparable<JobReference> {

    private static final long serialVersionUID = 1L;

    private String reference;


    public JobReference(final String customerCodeOfReference,final String numbersAfter) {

        //if (StringPredicates.isNullOrWhiteSpace(reference)) {
        //    throw new IllegalArgumentException("Error Message");
        //} METER VERIFICACAO
        this.reference = customerCodeOfReference + numbersAfter ;
    }

    protected JobReference() {
        // for ORM
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobReference)) {
            return false;
        }

        final JobReference that = (JobReference) o;
        return this.reference.equals(that.reference);
    }


    @Override
    public int hashCode() {
        return this.reference.hashCode();
    }

    @Override
    public String toString() {
        return this.reference;
    }

    @Override
    public int compareTo(final JobReference arg0) {
        return reference.compareTo(arg0.reference);
    }
}
