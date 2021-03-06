/*
 * Copyright (c) 2010-2013 Dmytro Pishchukhin (http://knowhowlab.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.knowhowlab.osgi.testing.utils.cmpn;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.knowhowlab.osgi.testing.utils.ServiceUtils.getService;
import static org.osgi.service.event.EventConstants.EVENT_FILTER;
import static org.osgi.service.event.EventConstants.EVENT_TOPIC;

/**
 * OSGi EventAdmin utilities class
 *
 * @author dpishchukhin
 * @see org.osgi.framework.Bundle
 * @see org.osgi.service.event.EventAdmin
 * @see org.osgi.service.event.Event
 * @see org.osgi.service.event.EventConstants
 * @see org.osgi.service.event.EventHandler
 */
public class EventAdminUtils {
    /**
     * Utility class. Only static methods are available.
     */
    private EventAdminUtils() {
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin    EventAdmin
     * @param topic         topic
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, String topic, long delayInMillis) {
        return postEvent(eventAdmin, topic, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin    EventAdmin
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, String topic, Dictionary properties, long delayInMillis) {
        return postEvent(eventAdmin, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin    EventAdmin
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, String topic, Map properties, long delayInMillis) {
        return postEvent(eventAdmin, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin    EventAdmin
     * @param event         event
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, Event event, long delayInMillis) {
        return postEvent(eventAdmin, event, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param bc            BundleContext
     * @param topic         topic
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, String topic, long delayInMillis) {
        return postEvent(bc, topic, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param bc            BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, String topic, Dictionary properties, long delayInMillis) {
        return postEvent(bc, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param bc            BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, String topic, Map properties, long delayInMillis) {
        return postEvent(bc, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param bc            BundleContext
     * @param event         event
     * @param delayInMillis time interval in millis to wait before post. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, Event event, long delayInMillis) {
        return postEvent(bc, event, delayInMillis, MILLISECONDS);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic      topic
     * @param delay      time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, String topic, long delay, TimeUnit timeUnit) {
        return postEvent(eventAdmin, new Event(topic, (Map) null), delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic      topic
     * @param properties event properties
     * @param delay      time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, String topic, Dictionary properties, long delay, TimeUnit timeUnit) {
        return postEvent(eventAdmin, new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic      topic
     * @param properties event properties
     * @param delay      time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(EventAdmin eventAdmin, String topic, Map properties, long delay, TimeUnit timeUnit) {
        return postEvent(eventAdmin, new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param delay    time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, String topic, long delay, TimeUnit timeUnit) {
        return postEvent(getService(bc, EventAdmin.class), new Event(topic, (Map) null), delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delay    time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, String topic, Dictionary properties, long delay, TimeUnit timeUnit) {
        return postEvent(getService(bc, EventAdmin.class), new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delay    time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, String topic, Map properties, long delay, TimeUnit timeUnit) {
        return postEvent(getService(bc, EventAdmin.class), new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param bc       BundleContext
     * @param event    event
     * @param delay    time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(BundleContext bc, final Event event, long delay, TimeUnit timeUnit) {
        return postEvent(getService(bc, EventAdmin.class), event, delay, timeUnit);
    }

    /**
     * Post an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param event      event
     * @param delay      time interval to wait before post. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> postEvent(final EventAdmin eventAdmin, final Event event, long delay, TimeUnit timeUnit) {
        if (eventAdmin == null) {
            throw new NullPointerException("EventAdmin is null");
        }
        return Executors.newSingleThreadScheduledExecutor().schedule(new Callable<Object>() {
            public Object call() throws Exception {
                eventAdmin.postEvent(event);
                return null;
            }
        }, delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic         topic
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, String topic, long delayInMillis) {
        return sendEvent(eventAdmin, topic, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, String topic, Dictionary properties, long delayInMillis) {
        return sendEvent(eventAdmin, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, String topic, Map properties, long delayInMillis) {
        return sendEvent(eventAdmin, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param event      event
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, Event event, long delayInMillis) {
        return sendEvent(eventAdmin, event, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, String topic, long delayInMillis) {
        return sendEvent(bc, topic, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, String topic, Dictionary properties, long delayInMillis) {
        return sendEvent(bc, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, String topic, Map properties, long delayInMillis) {
        return sendEvent(bc, topic, properties, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param event      event
     * @param delayInMillis time interval in millis to wait before send. If zero, the method will not wait.
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, Event event, long delayInMillis) {
        return sendEvent(bc, event, delayInMillis, MILLISECONDS);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic         topic
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, String topic, long delay, TimeUnit timeUnit) {
        return sendEvent(eventAdmin, new Event(topic, (Map) null), delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic         topic
     * @param properties    event properties
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, String topic, Dictionary properties, long delay, TimeUnit timeUnit) {
        return sendEvent(eventAdmin, new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param topic         topic
     * @param properties    event properties
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(EventAdmin eventAdmin, String topic, Map properties, long delay, TimeUnit timeUnit) {
        return sendEvent(eventAdmin, new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, String topic, long delay, TimeUnit timeUnit) {
        return sendEvent(getService(bc, EventAdmin.class), new Event(topic, (Map) null), delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, String topic, Dictionary properties, long delay, TimeUnit timeUnit) {
        return sendEvent(getService(bc, EventAdmin.class), new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param topic         topic
     * @param properties    event properties
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, String topic, Map properties, long delay, TimeUnit timeUnit) {
        return sendEvent(getService(bc, EventAdmin.class), new Event(topic, properties), delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param bc       BundleContext
     * @param event      event
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(BundleContext bc, final Event event, long delay, TimeUnit timeUnit) {
        return sendEvent(getService(bc, EventAdmin.class), event, delay, timeUnit);
    }

    /**
     * Send an Event with delay
     *
     * @param eventAdmin EventAdmin
     * @param event      event
     * @param delay      time interval to wait before send. If zero, the method will not wait.
     * @param timeUnit   time unit for the time interval
     * @return The Future's <tt>get</tt> method will return <tt>null</tt> upon <em>successful</em> completion.
     * @since 1.0
     */
    public static Future<?> sendEvent(final EventAdmin eventAdmin, final Event event, long delay, TimeUnit timeUnit) {
        if (eventAdmin == null) {
            throw new NullPointerException("EventAdmin is null");
        }
        return Executors.newSingleThreadScheduledExecutor().schedule(new Callable<Object>() {
            public Object call() throws Exception {
                eventAdmin.sendEvent(event);
                return null;
            }
        }, delay, timeUnit);
    }

    /**
     * Wait for Event with topics
     *
     * @param bc              BundleContext
     * @param topic           topic
     * @param timeoutInMillis time interval in millis to wait. If zero, the method will wait indefinitely.
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String topic, long timeoutInMillis) {
        return waitForEvent(bc, topic, timeoutInMillis, MILLISECONDS);
    }

    /**
     * Wait for Event with topic and filter
     *
     * @param bc              BundleContext
     * @param topic           topic
     * @param filter          filter
     * @param timeoutInMillis time interval in millis to wait. If zero, the method will wait indefinitely.
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String topic, Filter filter, long timeoutInMillis) {
        return waitForEvent(bc, topic, filter, timeoutInMillis, MILLISECONDS);
    }

    /**
     * Wait for Event with topics
     *
     * @param bc              BundleContext
     * @param topics          topics
     * @param timeoutInMillis time interval in millis to wait. If zero, the method will wait indefinitely.
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String[] topics, long timeoutInMillis) {
        return waitForEvent(bc, topics, timeoutInMillis, MILLISECONDS);
    }

    /**
     * Wait for Event with topics and filter
     *
     * @param bc              BundleContext
     * @param topics          topics
     * @param filter          filter
     * @param timeoutInMillis time interval in millis to wait. If zero, the method will wait indefinitely.
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String[] topics, Filter filter, long timeoutInMillis) {
        return waitForEvent(bc, topics, filter, timeoutInMillis, MILLISECONDS);
    }

    /**
     * Wait for Event with topic
     *
     * @param bc       BundleContext
     * @param topic    topic
     * @param timeout  time interval to wait. If zero, the method will wait indefinitely.
     * @param timeUnit time unit for the time interval
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String topic, long timeout, TimeUnit timeUnit) {
        return waitForEvent(bc, topic, null, timeout, timeUnit);
    }

    /**
     * Wait for Event with topic and filter
     *
     * @param bc       BundleContext
     * @param topic    topic
     * @param filter   filter
     * @param timeout  time interval to wait. If zero, the method will wait indefinitely.
     * @param timeUnit time unit for the time interval
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String topic, Filter filter, long timeout, TimeUnit timeUnit) {
        CountDownLatch latch = new CountDownLatch(1);

        long timeoutInMillis = timeUnit.toMillis(timeout);
        EventHandlerImpl handler = new EventHandlerImpl(latch);
        Dictionary<String, Object> props = new Hashtable<String, Object>();
        if (topic != null) {
            props.put(EVENT_TOPIC, topic);
        }
        if (filter != null) {
            props.put(EVENT_FILTER, filter.toString());
        }
        ServiceRegistration registration = bc.registerService(EventHandler.class.getName(), handler, props);

        try {
            return waitForEvent(handler, timeoutInMillis, latch);
        } catch (InterruptedException e) {
            return null;
        } finally {
            registration.unregister();
        }
    }

    /**
     * Wait for Event with topics
     *
     * @param bc       BundleContext
     * @param topics   topics
     * @param timeout  time interval to wait. If zero, the method will wait indefinitely.
     * @param timeUnit time unit for the time interval
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String[] topics, long timeout, TimeUnit timeUnit) {
        return waitForEvent(bc, topics, null, timeout, timeUnit);
    }

    /**
     * Wait for Event with topics and filter
     *
     * @param bc       BundleContext
     * @param topics   topics
     * @param filter   filter
     * @param timeout  time interval to wait. If zero, the method will wait indefinitely.
     * @param timeUnit time unit for the time interval
     * @return Event or <code>null</code>
     * @throws NullPointerException If <code>bc</code> or <code>timeUnit</code> are <code>null</code>
     * @since 1.0
     */
    public static Event waitForEvent(BundleContext bc, String[] topics, Filter filter, long timeout, TimeUnit timeUnit) {
        CountDownLatch latch = new CountDownLatch(1);

        long timeoutInMillis = timeUnit.toMillis(timeout);
        EventHandlerImpl handler = new EventHandlerImpl(latch);
        Dictionary<String, Object> props = new Hashtable<String, Object>();
        if (topics != null) {
            props.put(EVENT_TOPIC, topics);
        }
        if (filter != null) {
            props.put(EVENT_FILTER, filter.toString());
        }
        ServiceRegistration registration = bc.registerService(EventHandler.class.getName(), handler, props);

        try {
            return waitForEvent(handler, timeoutInMillis, latch);
        } catch (InterruptedException e) {
            return null;
        } finally {
            registration.unregister();
        }
    }

    private static Event waitForEvent(EventHandlerImpl handler, long timeoutInMillis, CountDownLatch latch)
            throws InterruptedException {
        if (timeoutInMillis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        if (latch.await(timeoutInMillis, MILLISECONDS)) {
            return handler.getEvent();
        } else {
            return null;
        }
    }

    private static class EventHandlerImpl implements EventHandler {
        private CountDownLatch latch;

        private Event event;

        public EventHandlerImpl(CountDownLatch latch) {
            this.latch = latch;
        }

        public void handleEvent(Event event) {
            this.event = event;
            latch.countDown();
        }

        public Event getEvent() {
            return event;
        }
    }
}
