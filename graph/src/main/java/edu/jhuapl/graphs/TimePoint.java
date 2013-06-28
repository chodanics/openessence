/*
 * Copyright (c) 2013 The Johns Hopkins University/Applied Physics Laboratory
 *                             All rights reserved.
 *
 * This material may be used, modified, or reproduced by or for the U.S.
 * Government pursuant to the rights granted under the clauses at
 * DFARS 252.227-7013/7014 or FAR 52.227-14.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * NO WARRANTY.   THIS MATERIAL IS PROVIDED "AS IS."  JHU/APL DISCLAIMS ALL
 * WARRANTIES IN THE MATERIAL, WHETHER EXPRESS OR IMPLIED, INCLUDING (BUT NOT
 * LIMITED TO) ANY AND ALL IMPLIED WARRANTIES OF PERFORMANCE,
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT OF
 * INTELLECTUAL PROPERTY RIGHTS. ANY USER OF THE MATERIAL ASSUMES THE ENTIRE
 * RISK AND LIABILITY FOR USING THE MATERIAL.  IN NO EVENT SHALL JHU/APL BE
 * LIABLE TO ANY USER OF THE MATERIAL FOR ANY ACTUAL, INDIRECT,
 * CONSEQUENTIAL, SPECIAL OR OTHER DAMAGES ARISING FROM THE USE OF, OR
 * INABILITY TO USE, THE MATERIAL, INCLUDING, BUT NOT LIMITED TO, ANY DAMAGES
 * FOR LOST PROFITS.
 */

package edu.jhuapl.graphs;

import java.util.Date;
import java.util.Map;

/**
 * A basic bean implementation of {@link TimePointInterface}.
 *
 * @see TimePointInterface
 */
public class TimePoint implements TimePointInterface {

    private final Number value;
    private final Date date;
    private final Map<String, Object> metadata;

    /**
     * Constructs a time point with the given date, value and metadata.
     *
     * @param date     the date
     * @param value    the value
     * @param metadata the metadata
     */
    public TimePoint(Date date, Number value, Map<String, Object> metadata) {
        this.value = value;
        this.date = date;
        this.metadata = metadata;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getDescriminator() {
        return date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getValue() {
        return value;
    }

}
